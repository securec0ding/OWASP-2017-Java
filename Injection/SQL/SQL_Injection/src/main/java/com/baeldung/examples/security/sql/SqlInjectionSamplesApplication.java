protected void Button1_Click(object sender, EventArgs e)
        {
        string connect = "MyConnString"
        string query = "Select Count(*) From Users Where Username = '" + UserName.Text + "' And Password = '" + Password.Text + "'"
        int result = 0;
        using (var conn = new SqlConnection(connect))
        {
        using (var cmd = new SqlCommand(query, conn))
        {
        conn.Open();
        result = (int)cmd.ExecuteScalar();
        }
        }
        if (result > 0)
        {
        Response.Redirect("LoggedIn.aspx");
        }
        else
        {
        Literal1.Text = "Invalid credentials"
        }