var form = document.getElementById('myform').addEventListener('submit',e =>{
e.preventDefault();
var account = document.getElementById('account').value;
var firstname = document.getElementById('firstname').value;
var lastname =document.getElementById('lastname').value;
var email=document.getElementById('email').value;
var contact=document.getElementById('contact').value;
console.log("hello");
fetch('http://localhost:8082/account-reference-data-service/users/createAccount', {
  method: 'POST',
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin' :'*',
    'Access-Control-Allow-Headers':'*'
  },
  body: JSON.stringify({
    account_no:account,
    firstname:firstname,
    lastname:lastname,
    email:email,
    contact:contact
  })
}).then((response) => {
  if (response.ok) { // Check for a non 2xx status code
    console.log('Network response was ok');
  }
  console.log("out");
}).catch(err=>res.status(200).send('Wrong user name or password.'));
// .then(response => response.text()).then(response =>{
//     if(JSON.parse( response)[0].message==="success"){
//         location.href="showdata.html";
//     }
//     else{
//         console.log("not");
//     }

// })
// .catch(err => console.log(err));
})