import { Component, OnInit } from '@angular/core';
import { TaskService } from '../services/TaskService';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Route } from '@angular/router';

@Component({
  selector: 'app-task-update',
  imports: [CommonModule,
    FormsModule
  ],
  templateUrl: './task-update.component.html',
  styleUrl: './task-update.component.css'
})
export class TaskUpdateComponent implements OnInit {

  constructor(private taskService : TaskService, private router : Route){}

  Task = {
    title : "",
    description : "",
    dueDate : "",
    status : ""
  }
  tasks : any[] = [];

  ngOnInit(): void {
    
  }

  OnSubmit(){}

}
