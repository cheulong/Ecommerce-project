import { Component, OnInit } from '@angular/core';
import {Course} from '../../students/course';
import {Http} from '@angular/http';
import {CourseServerService} from '../../service/course-server.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  constructor(private courseService:CourseServerService,private router:Router) { }
  course:any = {};
  ngOnInit() {

  }



  addCourse(course:Course){
    let result: Course;
    this.courseService.addCourse(course).subscribe(resultCourse => {
        result = resultCourse;
        if (result != null){
          this.router.navigate(['/list']);
        }else{
          alert("Error in adding the Course");
        }
      });
    }






}
