SELECT project.ID, SUM(worker.SALARY) * TIMESTAMPDIFF(MONTH, START_DATE, FINISH_DATE) AS PRICE
FROM project
JOIN project_worker ON project.ID = project_worker.PROJECT_ID
JOIN worker ON project_worker.WORKER_ID = worker.ID
GROUP BY project.ID
ORDER BY PRICE DESC;