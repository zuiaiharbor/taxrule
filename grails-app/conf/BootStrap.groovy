import groovy.sql.Sql

import java.util.logging.Level

import com.taxapp.Role
import com.taxapp.User

class BootStrap {

	def init = { servletContext ->
		def roleMap = setupRoleIfNotExists()

		// �ͥ��ƥ���SQL�Υ�����
		if (System.properties['debug.sql'] == 'true') {
			Sql.LOG.level = Level.FINE
		}

		// Config.groovy��ͬ����environments��DSLӛ����ʹ���롣
		environments {
			development { setupUserIfNotExists(roleMap) }
		}
	}

	private setupRoleIfNotExists() {
		// ���ڤ��Ƥ��ʤ����ϡ���Ҏ׷�Ӥ��뤿��Υإ�ѥ���`����
		def createIfNotExists = { authority ->
			Role.findByAuthority(authority) ?: new Role(authority: authority).save(failOnError: true)
		}

		// ��`���׷�Ӥ��롣
		return [
			user: createIfNotExists("ROLE_USER"),
			admin: createIfNotExists("ROLE_ADMIN"),
		]
	}

	private setupUserIfNotExists(roleMap) {
		def createIfNotExists = { name, roles ->
			User.findByUsername(name) ?: new User(username: name, enabled: true, roles: roles, password: "123456").save(failOnError: true)
		}

		// ���ߩ`��`����׷�Ӥ��롣
		createIfNotExists("admin", roleMap.admin)
		createIfNotExists("john", roleMap.admin)
		createIfNotExists("tom", roleMap.user)
		createIfNotExists("smith", roleMap.user)
	}

	def destroy = {
	}
}
