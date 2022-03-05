 

  
  let cartItems= [];
  const products= [
    {
      "product": {
        "id": 1,
        "name": "Book 1",
        "desc": "This is book 1"
      }
    },
    {
      "product": {
        "id": 2,
        "name": "Book 2",
        "desc": "This is book 2"
      }
    },
    {
      "product": {
        "id": 3,
        "name": "Book 3",
        "desc": "This is book 3"
      }
    },
    {
      "product": {
        "id": 4,
        "name": "Book 4",
        "desc": "This is book 4"
      }
    },
    {
      "product": {
        "id": 5,
        "name": "Book 5",
        "desc": "This is book 5"
      }
    }
  ];
  document.addEventListener('DOMContentLoaded', fetchData());
  function fetchData() {

      //Getting cors error so used the same json here as well.
      // GET Request in backend service is returing the data successfully although not used here
    
    fetch("http://localhost:8080/getProducts").then(function(response) {
        return response;
      }).then(function(data) {
        products= data;  
        console.log(data);
      }).catch(function() {
        console.log("Booo");
      });
    
      if(products) {
          let text='';
          for(let i=0; i<products.length; i++) {
                let id= products[i].product.id;
                let desc = products[i].product.desc;
                let name = products[i].product.name;
                text +=`<li> ID: ${id} Name: ${name} Descriptiom: ${desc} </li> <button class=${id} id=cart>Add to Cart</button>`;
           }
           document.querySelector('#products').innerHTML= text;
      }
}

document.addEventListener('click', (e) =>{
    if(e.target.id=="cart") {
        let idToAdd = e.target.className;
        console.log(idToAdd);
        cartItems.push(products[idToAdd-1].product)
        console.log(cartItems)
    }
})

document.addEventListener('click', (e) =>{
    if(e.target.id=="showCart") {
        if(cartItems) {
            let text='';
            for(let i=0; i<cartItems.length; i++) {
                  let id= cartItems[i].id;
                  let desc = cartItems[i].desc;
                  let name = cartItems[i].name;
                  text +=`<li> ID: ${id} Name: ${name} Descriptiom: ${desc} </li>`;
             }
             document.querySelector('#cartItems').innerHTML= text;
        }
    }
})