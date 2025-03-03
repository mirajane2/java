import { CommonModule, formatDate } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TaskService } from '../services/TaskService';
import { Router } from '@angular/router';
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';


registerLocaleData(localeFr);

@Component({
  selector: 'app-task-form',
  imports: [
    FormsModule,
    CommonModule
  ],
  templateUrl: './task-form.component.html',
  styleUrl: './task-form.component.css'
})
export class TaskFormComponent{
  
  constructor(private taskService : TaskService,
            private router : Router
  ){}

  Task = {
    title : "",
    description : "",
    dueDate : "",
    status : ""
  }
  tasks : any[] = [];


  OnSubmit() {
    if (this.Task.dueDate) {
      this.Task.dueDate = formatDate(this.Task.dueDate, 'dd/MM/yy', 'fr-FR');
    }
    console.log('Données soumises :', this.Task);
    this.taskService.createTask(this.Task).subscribe({
        next: () => {
            console.log('Task created:');
            this.router.navigate(['/api/task']);
            console.log('Données soumises :', this.Task);
        },
        error: (error) => {
            console.error('Error creating task:', error);
        },
        complete: () => {
            console.log('Task creation process complete.');
        }
      })
    }
}
