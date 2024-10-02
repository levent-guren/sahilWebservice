import { Component, OnInit } from '@angular/core';
import { BirlikService } from '../service/birlik.service';
import { Birlik } from '../beans/Birlik';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-birlik',
  templateUrl: './birlik.component.html',
  styleUrl: './birlik.component.scss'
})
export class BirlikComponent implements OnInit {
  birlikler: Birlik[] = [];
  form!: FormGroup;
  seciliBirlikId = 0;

  constructor(
    private birlikService: BirlikService,
    private fb: FormBuilder  // For form creation
  ) {
    this.createForm();
  }

  createForm() {
    this.form = this.fb.group({
      birlikAdi: '',
      birlikIl: '',
    });
  }

  ngOnInit(): void {
    this.birlikService.getBirlikler().subscribe({
      next: (data: Birlik[]) => {
        this.birlikler = data;
      },
      error: (error) => {
        console.error('Error getting birlikler:', error);
      }
    });
  }
  birlikEkle() {
    const adi = this.form.get('birlikAdi')!.value;
    const il = this.form.get('birlikIl')!.value;
    this.birlikService.birlikEkleGuncelle({ id: null, adi: adi, il: il }).subscribe({
      next: (data: Birlik) => {
        this.birlikler.push(data);
        this.form.reset();
      },
      error: (error) => {
        console.error('Error adding birlik:', error);
      }
    });
  }
  birlikGuncelle() {
    const adi = this.form.get('birlikAdi')!.value;
    const il = this.form.get('birlikIl')!.value;
    this.birlikService.birlikEkleGuncelle({ id: this.seciliBirlikId, adi: adi, il: il }).subscribe({
      next: (data: Birlik) => {
        this.form.reset();
        this.seciliBirlikId = 0;
        this.birlikBilgisiGuncelle(data);
      },
      error: (error) => {
        console.error('Error updating birlik:', error);
      }
    });
  }
  birlikBilgisiGuncelle(data: Birlik) {
    const index = this.birlikler.findIndex(b => b.id === data.id);
    this.birlikler[index].adi = data.adi;
    this.birlikler[index].il = data.il;
  }
  birlikSec(birlik: Birlik) {
    if (this.seciliBirlikId == birlik.id) {
      this.form.reset();
      this.seciliBirlikId = 0;
    } else {
      this.seciliBirlikId = birlik.id;
      this.form.setValue({
        birlikAdi: birlik.adi,
        birlikIl: birlik.il,
      });
    }
  }
  birlikSil() {
    if (this.seciliBirlikId != 0) {
      this.birlikService.birlikSil(this.seciliBirlikId).subscribe({
        next: () => {
          const index = this.birlikler.findIndex(b => b.id === this.seciliBirlikId);
          this.birlikler.splice(index, 1);
          this.form.reset();
          this.seciliBirlikId = 0;
        },
        error: (error) => {
          console.error('Error deleting birlik:', error);
        }
      });
    }
  }
}

