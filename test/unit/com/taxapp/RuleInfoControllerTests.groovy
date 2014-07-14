package com.taxapp



import org.junit.*
import grails.test.mixin.*

@TestFor(RuleInfoController)
@Mock(RuleInfo)
class RuleInfoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/ruleInfo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.ruleInfoInstanceList.size() == 0
        assert model.ruleInfoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.ruleInfoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.ruleInfoInstance != null
        assert view == '/ruleInfo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/ruleInfo/show/1'
        assert controller.flash.message != null
        assert RuleInfo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/ruleInfo/list'

        populateValidParams(params)
        def ruleInfo = new RuleInfo(params)

        assert ruleInfo.save() != null

        params.id = ruleInfo.id

        def model = controller.show()

        assert model.ruleInfoInstance == ruleInfo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/ruleInfo/list'

        populateValidParams(params)
        def ruleInfo = new RuleInfo(params)

        assert ruleInfo.save() != null

        params.id = ruleInfo.id

        def model = controller.edit()

        assert model.ruleInfoInstance == ruleInfo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/ruleInfo/list'

        response.reset()

        populateValidParams(params)
        def ruleInfo = new RuleInfo(params)

        assert ruleInfo.save() != null

        // test invalid parameters in update
        params.id = ruleInfo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/ruleInfo/edit"
        assert model.ruleInfoInstance != null

        ruleInfo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/ruleInfo/show/$ruleInfo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        ruleInfo.clearErrors()

        populateValidParams(params)
        params.id = ruleInfo.id
        params.version = -1
        controller.update()

        assert view == "/ruleInfo/edit"
        assert model.ruleInfoInstance != null
        assert model.ruleInfoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/ruleInfo/list'

        response.reset()

        populateValidParams(params)
        def ruleInfo = new RuleInfo(params)

        assert ruleInfo.save() != null
        assert RuleInfo.count() == 1

        params.id = ruleInfo.id

        controller.delete()

        assert RuleInfo.count() == 0
        assert RuleInfo.get(ruleInfo.id) == null
        assert response.redirectedUrl == '/ruleInfo/list'
    }
}
