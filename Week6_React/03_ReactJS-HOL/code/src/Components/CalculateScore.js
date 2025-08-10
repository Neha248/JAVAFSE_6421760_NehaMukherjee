import React from "react";
import "../Stylesheets/mystyle.css";

function CalculateScore({ name, school, total, goal }) {
  const average = total / goal;

  return (
    <div className="score-container">
      <h2>Student Score Calculator</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>School:</strong> {school}</p>
      <p><strong>Total Marks:</strong> {total}</p>
      <p><strong>Goal Subjects:</strong> {goal}</p>
      <p className="average"><strong>Average Score:</strong> {average.toFixed(2)}</p>
    </div>
  );
}

export default CalculateScore;
