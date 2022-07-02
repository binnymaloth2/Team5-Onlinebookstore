import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  list:any[]
  constructor(private api:ApiService) { }

  ngOnInit(): void {
    this.loadData()
  }

   loadData(){
    this.api.allorders().subscribe({
      next:resp=>{
        this.list=resp       
      }
    })
  }
}
