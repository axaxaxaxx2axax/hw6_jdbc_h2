SELECT client.NAME, COUNT(project.ID) AS PROJECT_COUNT
FROM client 
JOIN project ON client.ID = project.CLIENT_ID
GROUP BY client.NAME
HAVING COUNT(project.ID) = (
    SELECT MAX(PROJECT_COUNT)
    FROM (
        SELECT COUNT(project.ID) AS PROJECT_COUNT
        FROM project
        GROUP BY project.CLIENT_ID
    ) AS subquery_max_projects
);