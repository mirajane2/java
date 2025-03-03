import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TaskService } from '../services/TaskService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-list',
  imports: [CommonModule],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css'
})
export class TaskListComponent implements OnInit {
  tasks : any[] = [];

  constructor(private taskService : TaskService, private route : Router ){}

  ngOnInit(): void {
    this.taskService.getTasks().subscribe((data : any) => {
      this.tasks = data;
    })
  }

  CreateTask() {
    this.route.navigate(["/api/task/form"])
  }

  DetailTask(id : number){
    this.route.navigate(["/api/task/", id])
  }

  UpdateTask(id :number) {
    this.route.navigate(["/api/task/", id])
  }

  DeleteTask(id : number) {
    if(window.confirm("Voulez vous supprimer cette tache")) {
      this.taskService.deleteTask(id).subscribe(() => {
        this.tasks = this.tasks.filter(task => task.id !== id)
      })
    }
    alert("Cette tache a été supprimé");
    
  }
}
