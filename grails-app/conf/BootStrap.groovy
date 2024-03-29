import groovy.sql.Sql

import java.util.logging.Level

import com.taxapp.Role
import com.taxapp.User

class BootStrap {

	def init = { servletContext ->
		def roleMap = setupRoleIfNotExists()

		// ネイティブSQLのロギング喘
		if (System.properties['debug.sql'] == 'true') {
			Sql.LOG.level = Level.FINE
		}

		// Config.groovyと揖��にenvironmentsのDSL��隈が聞える。
		environments {
			development { setupUserIfNotExists(roleMap) }
		}
	}

	private setupRoleIfNotExists() {
		// 贋壓していない��栽、仟�ﾗ啓咾垢襪燭瓩離悒襯僖�ロ�`ジャ
		def createIfNotExists = { authority ->
			Role.findByAuthority(authority) ?: new Role(authority: authority).save(failOnError: true)
		}

		// ロ�`ルを弖紗する。
		return [
			user: createIfNotExists("ROLE_USER"),
			admin: createIfNotExists("ROLE_ADMIN"),
		]
	}

	private setupUserIfNotExists(roleMap) {
		def createIfNotExists = { name, roles ->
			User.findByUsername(name) ?: new User(username: name, enabled: true, roles: roles, password: "123456").save(failOnError: true)
		}

		// ダミ�`ユ�`ザを弖紗する。
		createIfNotExists("admin", roleMap.admin)
		createIfNotExists("john", roleMap.admin)
		createIfNotExists("tom", roleMap.user)
		createIfNotExists("smith", roleMap.user)
	}

	def destroy = {
	}
}
