package com.taxapp

import org.springframework.dao.DataIntegrityViolationException

class RuleInfoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [ruleInfoInstanceList: RuleInfo.list(params), ruleInfoInstanceTotal: RuleInfo.count()]
    }

    def create() {
        [ruleInfoInstance: new RuleInfo(params)]
    }

    def save() {
        def ruleInfoInstance = new RuleInfo(params)
        if (!ruleInfoInstance.save(flush: true)) {
            render(view: "create", model: [ruleInfoInstance: ruleInfoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'ruleInfo.label', default: 'RuleInfo'), ruleInfoInstance.id])
        redirect(action: "show", id: ruleInfoInstance.id)
    }

    def show(Long id) {
        def ruleInfoInstance = RuleInfo.get(id)
        if (!ruleInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ruleInfo.label', default: 'RuleInfo'), id])
            redirect(action: "list")
            return
        }

        [ruleInfoInstance: ruleInfoInstance]
    }

    def edit(Long id) {
        def ruleInfoInstance = RuleInfo.get(id)
        if (!ruleInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ruleInfo.label', default: 'RuleInfo'), id])
            redirect(action: "list")
            return
        }

        [ruleInfoInstance: ruleInfoInstance]
    }

    def update(Long id, Long version) {
        def ruleInfoInstance = RuleInfo.get(id)
        if (!ruleInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ruleInfo.label', default: 'RuleInfo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (ruleInfoInstance.version > version) {
                ruleInfoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ruleInfo.label', default: 'RuleInfo')] as Object[],
                          "Another user has updated this RuleInfo while you were editing")
                render(view: "edit", model: [ruleInfoInstance: ruleInfoInstance])
                return
            }
        }

        ruleInfoInstance.properties = params

        if (!ruleInfoInstance.save(flush: true)) {
            render(view: "edit", model: [ruleInfoInstance: ruleInfoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'ruleInfo.label', default: 'RuleInfo'), ruleInfoInstance.id])
        redirect(action: "show", id: ruleInfoInstance.id)
    }

    def delete(Long id) {
        def ruleInfoInstance = RuleInfo.get(id)
        if (!ruleInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ruleInfo.label', default: 'RuleInfo'), id])
            redirect(action: "list")
            return
        }

        try {
            ruleInfoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'ruleInfo.label', default: 'RuleInfo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ruleInfo.label', default: 'RuleInfo'), id])
            redirect(action: "show", id: id)
        }
    }
}
