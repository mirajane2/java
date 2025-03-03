import { Routes } from '@angular/router';
import { TaskListComponent } from './task-list/task-list.component';
import { TaskFormComponent } from './task-form/task-form.component';
import { TaskUpdateComponent } from './task-update/task-update.component';

export const routes: Routes = [
    {path : 'api/task', component : TaskListComponent},
    {path : 'api/task/form', component : TaskFormComponent},
    {path : 'api/task/:id', component : TaskUpdateComponent}
];
