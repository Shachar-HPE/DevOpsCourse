describe('TaskList App', function(){

    beforeEach(function(){
        browser.get('app/index.html');
    });

    it('should start with no tasks', function(){
        var taskList = element.all(by.repeater('task in tasks'));
        var taskText = element(by.model('newTaskText'));
        expect(taskList.count()).toBe(0);
    })

})