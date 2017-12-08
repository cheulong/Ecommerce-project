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
var router_1 = require("@angular/router");
var students_data_service_1 = require("../../service/students-data.service");
require("rxjs/add/operator/switchMap");
var StudentsViewComponent = (function () {
    function StudentsViewComponent(route, studentDataService) {
        this.route = route;
        this.studentDataService = studentDataService;
    }
    StudentsViewComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.isNoData = false;
        this.inputCount = 15;
        this.route.params
            .switchMap(function (params) { return _this.studentDataService.getStudent(+params['id']); })
            .subscribe(function (student) {
            if (student !== null)
                _this.student = student;
            else
                _this.isNoData = true;
        });
    };
    return StudentsViewComponent;
}());
StudentsViewComponent = __decorate([
    core_1.Component({
        selector: 'students-view',
        templateUrl: 'app/students/view/students.view.component.html',
        styleUrls: ['app/students/view/students.view.component.css']
    }),
    __metadata("design:paramtypes", [router_1.ActivatedRoute, students_data_service_1.StudentsDataService])
], StudentsViewComponent);
exports.StudentsViewComponent = StudentsViewComponent;
//# sourceMappingURL=students.view.component.js.map