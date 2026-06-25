-- Exercise 1: Control Structures

-- Scenario 1: Age-based loan discount
BEGIN
    FOR cust IN (SELECT c.CustomerID, l.LoanID, l.InterestRate,
                        FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS Age
                 FROM Customers c
                 JOIN Loans l ON c.CustomerID = l.CustomerID)
    LOOP
        IF cust.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = cust.LoanID;
            DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: '
                                  || cust.CustomerID
                                  || ' | Age: ' || cust.Age
                                  || ' | LoanID: ' || cust.LoanID);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: VIP status based on balance
ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';

BEGIN
    FOR cust IN (SELECT CustomerID, Name, Balance FROM Customers)
    LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers SET IsVIP = 'TRUE' WHERE CustomerID = cust.CustomerID;
            DBMS_OUTPUT.PUT_LINE('VIP Status set for: ' || cust.Name
                                  || ' | Balance: ' || cust.Balance);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Not VIP: ' || cust.Name
                                  || ' | Balance: ' || cust.Balance);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Loan due reminders within 30 days
BEGIN
    FOR loan IN (SELECT l.LoanID, c.Name, l.EndDate
                 FROM Loans l
                 JOIN Customers c ON l.CustomerID = c.CustomerID
                 WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30)
    LOOP
        DBMS_OUTPUT.PUT_LINE('REMINDER: Dear ' || loan.Name
                              || ', your Loan ID: ' || loan.LoanID
                              || ' is due on ' || TO_CHAR(loan.EndDate, 'DD-MON-YYYY')
                              || '. Please make your payment.');
    END LOOP;
END;
/