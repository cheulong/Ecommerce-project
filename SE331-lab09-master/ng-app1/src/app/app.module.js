"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var app_component_1 = require("./app.component");
var students_component_1 = require("./students/list/students.component");
var students_add_component_1 = require("./students/add/students.add.component");
var students_view_component_1 = require("./students/view/students.view.component");
var time_component_1 = require("./time/time.component");
var forms_1 = require("@angular/forms");
var students_data_service_1 = require("./service/students-data.service");
var http_1 = require("@angular/http");
var menu_component_1 = require("./menu/menu.component");
var file_not_found_component_1 = require("./filenotfound/file-not-found.component");
var app_routing_module_1 = require("./app-routing.module");
var student_routing_module_1 = require("./students/student-routing.module");
var common_1 = require("@angular/common");
var students_data_server_service_1 = require("./service/students-data-server.service");
var course_list_component_1 = require("./students/course-list/course-list.component");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        declarations: [app_component_1.AppComponent,
            students_component_1.StudentsComponent,
            students_add_component_1.StudentsAddComponent,
            students_view_component_1.StudentsViewComponent,
            time_component_1.TimeComponent,
            menu_component_1.MenuComponent, file_not_found_component_1.FileNotFoundComponent, course_list_component_1.CourseListComponent],
        imports: [platform_browser_1.BrowserModule, forms_1.FormsModule, http_1.HttpModule,
            student_routing_module_1.StudentRoutingModule, app_routing_module_1.AppRoutingModule],
        bootstrap: [app_component_1.AppComponent],
        providers: [{ provide: students_data_service_1.StudentsDataService, useClass: students_data_server_service_1.StudentsDataServerService },
            { provide: common_1.LocationStrategy, useClass: common_1.HashLocationStrategy }]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map