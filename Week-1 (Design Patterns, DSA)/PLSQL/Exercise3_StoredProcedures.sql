-- Exercise 3: Stored Procedures

-- Scenario 1: Monthly interest for savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all Savings accounts.');
    COMMIT;
END;
/
EXEC ProcessMonthlyInterest;

-- Scenario 2: Employee bonus by department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department    IN VARCHAR2,
    p_bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;
    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percent
                          || '% applied to department: ' || p_department);
    COMMIT;
END;
/
EXEC UpdateEmployeeBonus('IT', 10);

-- Scenario 3: Transfer funds between accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Insufficient balance in Account '
                              || p_from_account
                              || '. Available: ' || v_balance);
    ELSE
        UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE
        WHERE AccountID = p_from_account;
        UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE
        WHERE AccountID = p_to_account;
        DBMS_OUTPUT.PUT_LINE('SUCCESS: Transferred ' || p_amount
                              || ' from Account ' || p_from_account
                              || ' to Account ' || p_to_account);
        COMMIT;
    END IF;
END;
/
EXEC TransferFunds(1, 2, 500);
EXEC TransferFunds(3, 1, 9999);