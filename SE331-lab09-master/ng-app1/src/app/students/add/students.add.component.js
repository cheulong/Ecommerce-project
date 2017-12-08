"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var student_1 = require("../student");
var router_1 = require("@angular/router");
var students_data_service_1 = require("../../service/students-data.service");
var StudentsAddComponent = (function () {
    function StudentsAddComponent(studentDataService, router) {
        this.studentDataService = studentDataService;
        this.router = router;
        this.student = {};
    }
    ;
    StudentsAddComponent.prototype.ngOnInit = function () {
        this.student = new student_1.Student();
    };
    StudentsAddComponent.prototype.upQuantity = function (student) {
        student.penAmount++;
    };
    StudentsAddComponent.prototype.downQuantity = function (student) {
        if (student.penAmount > 0)
            student.penAmount--;
    };
    StudentsAddComponent.prototype.addStudent = function (student) {
        var _this = this;
        var result;
        console.log(student);
        var inputEl = this.inputEl.nativeElement;
        this.studentDataService.addStudent(student, inputEl.files.item(0))
            .subscribe(function (resultStudent) {
            result = resultStudent;
            if (result != null) {
                _this.router.navigate(['/list']);
            }
            else {
                alert("Error in adding the student");
            }
        });
    };
    StudentsAddComponent.prototype.onFileChange = function (event, student) {
        var filename = event.target.files[0].name;
        console.log(filename);
        student.image = filename;
        student.file = event.target.files[0];
    };
    return StudentsAddComponent;
}());
__decorate([
    core_1.ViewChild('fileInput'),
    __metadata("design:type", core_1.ElementRef)
], StudentsAddComponent.prototype, "inputEl", void 0);
StudentsAddComponent = __decorate([
    core_1.Component({
        selector: 'students-add',
        templateUrl: 'app/students/add/students.add.component.html',
        styleUrls: ['app/students/add/students.add.component.css']
    }),
    __metadata("design:paramtypes", [students_data_service_1.StudentsDataService, router_1.Router])
], StudentsAddComponent);
exports.StudentsAddComponent = StudentsAddComponent;
//# sourceMappingURL=students.add.component.js.map