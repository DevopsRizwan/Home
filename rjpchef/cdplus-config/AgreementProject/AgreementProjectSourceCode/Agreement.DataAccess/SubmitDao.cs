/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.SqlClient;

namespace Agreement.DataAccess
{
    public class SubmitDao : SQLDataAccess
    {
        public int Update(int agreementTypeId)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@AgreementTypeID", agreementTypeId));
            object submitionStatus = null;
            submitionStatus = ExecuteScalar(DBCommands.SubmitAgreement);
            return Convert.ToInt32(submitionStatus);
        }

    }
}
