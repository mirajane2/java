import { Component, OnInit } from '@angular/core';
import { TaskService } from '../services/TaskService';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-task-update',
  imports: [
    CommonModule,
    FormsModule,
    DatePipe
  ],
  templateUrl: './task-update.component.html',
  styleUrl: './task-update.component.css',
  providers : [DatePipe]
})
export class TaskUpdateComponent implements OnInit {


  id! : number
  Task = {
    title : "",
    description : "",
    dueDate : "",
    status : ""
  }
  tasks : any[] = [];

  constructor(
    private taskService : TaskService, 
    private route : Router,
    private router : ActivatedRoute,
    private datePipe : DatePipe
  ){}

  ngOnInit(): void {
    this.id = Number(this.router.snapshot.paramMap.get('id'))
    this.taskService.getTaskById(this.id).subscribe({
      next: (data) => {
        this.Task = data;
        this.Task.dueDate = data.dueDate
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des données de la tache:', error);
        alert('Une erreur est survenue lors du chargement des données.')
      }
    });
  }
  

  OnSubmit(): void {
    console.log('Données envoyées:', this.Task);
    const formattedDueDate = this.datePipe.transform(this.Task.dueDate, 'dd/MM/yy');
    if (!formattedDueDate) {
      alert("La date d'échéance est invalide.");
      return
    }
      this.Task.dueDate = formattedDueDate;     
      this.taskService.updateTask( this.id, this.Task).subscribe({
        next: (response) => {
          this.route.navigate(['api/tasks']); 
        },
        error: (error) => {
          console.error('Erreur lors de la mise à jour:', error);
          alert('Une erreur est survenue. Veuillez réessayer.');
        },
      });
    }
}
