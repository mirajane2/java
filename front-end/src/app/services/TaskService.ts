import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn : "root"
})
export class TaskService {

    constructor(private http: HttpClient){}

    getTasks() : Observable<any> {
        return this.http.get(`http://localhost:8080/api/tasks`);
    }
    
    getTaskById(id : number) : Observable<any>{
        return this.http.get(`http://localhost:8080/api/tasks/${id}`)
    }

    createTask(task : any){
        return this.http.post(`http://localhost:8080/api/tasks`, task);
    }

    updateTask(id : number, task :String) {
        return this.http.put(`http://localhost:8080/api/tasks/${id}`, task);
    }

    deleteTask(id : number) {
        return this.http.delete(`http://localhost:8080/api/tasks/${id}`)
    }
}