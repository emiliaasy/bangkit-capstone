const slide = document.querySelector('.containerproses');
const pindah = document.querySelectorAll('.proses')

const prevBtn = document.querySelector('#prevBtn');
const nextBtn = document.querySelector('#nextBtn');

let counter = 1;
const size = pindah[0].clientWidth;

slide.style.transform = 'translateX(' + (-size * counter ) +'px)';

nextBtn.addEventListener('click',()=>{
    if (counter >= pindah.length - 1) return;
    slide.style.transition = "transform 0.4s ease-in-out";
    counter++;
    slide.style.transform = 'translateX(' + (-size * counter ) +'px)';
});

prevBtn.addEventListener('click',()=>{
    if (counter <=0) return;
    slide.style.transition = "transform 0.4s ease-in-out";
    counter--;
    slide.style.transform = 'translateX(' + (-size * counter ) +'px)';
});

slide.addEventListener('transitionend',() =>{
    if (pindah[counter].id === 'awal'){
        slide.style.transition = "none";
        counter = pindah.length - 2;
        slide.style.transform = 'translateX(' + (-size * counter ) +'px)';
    }
    if (pindah[counter].id === 'akhir'){
        slide.style.transition = "none";
        counter = pindah.length - counter;
        slide.style.transform = 'translateX(' + (-size * counter ) +'px)';
    }
});

