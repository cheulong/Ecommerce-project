"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var students_component_1 = require("./list/students.component");
var students_add_component_1 = require("./add/students.add.component");
var students_view_component_1 = require("./view/students.view.component");
var studentRoutes = [
    { path: 'detail/:id', component: students_view_component_1.StudentsViewComponent },
    { path: 'view', component: students_view_component_1.StudentsViewComponent,
        data: {
            student: {
                "id": 2,
                "studentId": "SE-001",
                "name": "Prayuth",
                "surname": "The minister",
                "gpa": 3.59,
                "image": "images/tu.jpg",
                "featured": false,
                "penAmount": 15,
                "description": "The great man ever!!!!"
            }
        }
    },
    { path: 'add', component: students_add_component_1.StudentsAddComponent },
    { path: 'list', component: students_component_1.StudentsComponent },
    {
        path: '',
        redirectTo: '/list',
        pathMatch: 'full'
    }
];
var StudentRoutingModule = (function () {
    function StudentRoutingModule() {
    }
    return StudentRoutingModule;
}());
StudentRoutingModule = __decorate([
    core_1.NgModule({
        imports: [
            router_1.RouterModule.forRoot(studentRoutes)
        ],
        exports: [
            router_1.RouterModule
        ]
    })
], StudentRoutingModule);
exports.StudentRoutingModule = StudentRoutingModule;
//# sourceMappingURL=student-routing.module.js.map