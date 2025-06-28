--scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  FOR acc IN (
    SELECT AccountID, Balance
    FROM Accounts
    WHERE AccountType = 'Savings'
  ) LOOP
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountID = acc.AccountID;
  END LOOP;
END;

EXEC ProcessMonthlyInterest;

--scenario 2 
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  dept_name IN VARCHAR2,
  bonus_percent IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * bonus_percent / 100),
      HireDate = HireDate  
  WHERE Department = dept_name;
END;
EXEC UpdateEmployeeBonus('IT', 10);  -- Gives 10% bonus to IT department


--scenario 3 
CREATE OR REPLACE PROCEDURE TransferFunds (
  from_acc_id IN NUMBER,
  to_acc_id IN NUMBER,
  amount IN NUMBER
) AS
  from_balance NUMBER;
BEGIN
  -- Get balance of source account
  SELECT Balance INTO from_balance
  FROM Accounts
  WHERE AccountID = from_acc_id
  FOR UPDATE;

  IF from_balance < amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for transfer.');
  END IF;

  -- Deduct from source
  UPDATE Accounts
  SET Balance = Balance - amount,
      LastModified = SYSDATE
  WHERE AccountID = from_acc_id;

  -- Add to destination
  UPDATE Accounts
  SET Balance = Balance + amount,
      LastModified = SYSDATE
  WHERE AccountID = to_acc_id;
END;
EXEC TransferFunds(1, 2, 200);

--prints the changes made to the tables
SELECT * FROM Accounts;
SELECT * FROM Employees;
