const Names=document.getElementById("fullNames");
const Emails=document.getElementById("emails");
const Passwords=document.getElementById("passwords");
const Submits=document.getElementById("myForms");
Submits.addEventListener("submits", async e => {
e.preventDefault();
let payload = { fullNames: Names.value, emails:Emails.value, passwords:Passwords.value}
console.log(payload);
try{

 const response = await fetch(
    'http://localhost:9000/api/v1/users',
    {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(payload),
    }
  );
  const content = await response.json();
  const data = await content;

  if (!response.ok) {
    throw new Error(data.message);
    return;
  }
}
catch(e){}
}
)