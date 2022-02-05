# WebService
 Normalement f local hada howa url : "http://localhost:8007/Incidents"

1-----fct: récupérer la liste des incidents pour l'app web:

url : "/Incidents"



2-----fct: Ajouter un incident

url : "/AddIncident"

input: un fichier json 



3-----fct: récupérer la liste des incidents pour un déclarant donné

url : "/incidentsMobile/{IMEI du déclarant}"

input: hadak code dial telephone dialo




4----fct: supprimer un incident

url : "/Incident/{id de l'accident}"

input: id en spécifiant que la requête HTTP est DELETE 
