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
var http_1 = require("@angular/http");
var Rx_1 = require("rxjs/Rx");
var StudentsDataServerService = (function () {
    function StudentsDataServerService(http) {
        this.http = http;
    }
    StudentsDataServerService.prototype.getStudentsData = function () {
        var studentArray;
        return this.http.get('http://localhost:8080/student')
            .map(function (res) { return res.json(); });
    };
    StudentsDataServerService.prototype.getStudent = function (id) {
        var student;
        return this.http.get('http://localhost:8080/student/' + id)
            .map(function (res) {
            if (res) {
                if (res.status === 200) {
                    return res.json();
                }
                if (res.status === 204) {
                    return null;
                }
            }
        })
            .catch(function (error) {
            if (error.status === 500) {
                return Rx_1.Observable.throw(new Error(error.status));
            }
            else if (error.status === 400) {
                return Rx_1.Observable.throw(new Error(error.status));
            }
            else if (error.status === 409) {
                return Rx_1.Observable.throw(new Error(error.status));
            }
            else if (error.status === 406) {
                return Rx_1.Observable.throw(new Error(error.status));
            }
            return error;
        });
    };
    // addStudent(student: Student) {
    //   let formData = new FormData();
    //
    //   formData.append('file', student.file);
    //   student.file = null;
    //   formData.append('student', JSON.stringify(student));
    //   console.log(JSON.stringify(student));
    //   return this.http
    //     .post('http://localhost:8080/student', formData)
    //     .map(res => res.json);
    //
    // }
    StudentsDataServerService.prototype.addStudent = function (student, file) {
        var _this = this;
        var formData = new FormData();
        var fileName;
        formData.append('file', file);
        return this.http.post('http://localhost:8080/student/image', formData)
            .flatMap(function (filename) {
            student.image = filename.text();
            var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
            var options = new http_1.RequestOptions({ headers: headers, method: 'post' });
            var body = JSON.stringify(student);
            return _this.http.post('http://localhost:8080/student', body, options)
                .map(function (res) {
                return res.json();
            })
                .catch(function (error) {
                return Rx_1.Observable.throw(new Error(error.status));
            });
        });
    };
    return StudentsDataServerService;
}());
StudentsDataServerService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], StudentsDataServerService);
exports.StudentsDataServerService = StudentsDataServerService;
//# sourceMappingURL=students-data-server.service.js.map