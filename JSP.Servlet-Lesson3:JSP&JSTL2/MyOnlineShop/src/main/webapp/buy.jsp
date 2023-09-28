<!DOCTYPE html>
<html>
<head>
    <title>Trang thanh toán</title>
    <style>
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 5px;
        }

        h1 {
            text-align: center;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 10px;
        }

        input[type="text"] {
            padding: 10px;
            border-radius: 3px;
            border: 1px solid #ccc;
            margin-bottom: 15px;
        }

        input[type="submit"] {
            background-color: darkblue;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: darkblue;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="/paid-servlet" method="post">
        <h1>Pay</h1>

        <label for="name">Full name:</label>
        <input type="text" id="name" name="name" required>

        <label for="card-number">Card number:</label>
        <input type="text" id="card-number" name="card-number" required>

        <label for="expiry">Expiration date:</label>
        <input type="text" id="expiry" name="expiry" required>

        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv" required>

        <input type="submit" value="Pay">
    </form>
</div>
</body>
</html>