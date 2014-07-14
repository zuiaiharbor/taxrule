import groovy.sql.Sql

import java.util.logging.Level

import com.taxapp.Role
import com.taxapp.User

class BootStrap {

	def init = { servletContext ->
		def roleMap = setupRoleIfNotExists()

		// ネイティブSQLのロギング用
		if (System.properties['debug.sql'] == 'true') {
			Sql.LOG.level = Level.FINE
		}

		// Config.groovyと同様にenvironmentsのDSL記法が使える。
		environments {
			development { setupUserIfNotExists(roleMap) }
		}
	}

	private setupRoleIfNotExists() {
		// 存在していない場合、新規追加するためのヘルパクロージャ
		def createIfNotExists = { authority ->
			Role.findByAuthority(authority) ?: new Role(authority: authority).save(failOnError: true)
		}

		// ロールを追加する。
		return [
			user: createIfNotExists("ROLE_USER"),
			admin: createIfNotExists("ROLE_ADMIN"),
		]
	}

	private setupUserIfNotExists(roleMap) {
		def createIfNotExists = { name, roles ->
			User.findByUsername(name) ?: new User(username: name, enabled: true, roles: roles, password: "123456").save(failOnError: true)
		}

		// ダミーユーザを追加する。
		createIfNotExists("admin", roleMap.admin)
		createIfNotExists("john", roleMap.admin)
		createIfNotExists("tom", roleMap.user)
		createIfNotExists("smith", roleMap.user)
	}

	def destroy = {
	}
}
