/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Agreement.BusinessEntity;
using System.Data.SqlClient;

namespace Agreement.DataAccess
{
    public class ApproversDao : SQLDataAccess
    {
        public int Insert(ApproversEntity entity)
        {
            Parameters = new List<SqlParameter>();

            Parameters.Add(new SqlParameter("@AgreementApproversID", entity.AgreementApproversID));
            Parameters.Add(new SqlParameter("@AgreementTypeID", entity.AgreementTypeID));
            Parameters.Add(new SqlParameter("@AgreementReviewer", entity.AgreementReviewer));
            Parameters.Add(new SqlParameter("@BusinessReviewer", entity.BusinessReviewer));
            Parameters.Add(new SqlParameter("@LawyerApprover", entity.LawyerApprover));
            Parameters.Add(new SqlParameter("@OtherApprover", entity.OtherApprover));
            object aggrementApproversID = null;
            if (entity.AgreementApproversID == 0)
            {
                Parameters.Add(new SqlParameter("@Action", "C"));
                aggrementApproversID = ExecuteScalar(DBCommands.Approvers);
            }
            else
            {
                Parameters.Add(new SqlParameter("@Action", "U"));
                ExecCommand(DBCommands.Approvers);
                aggrementApproversID = entity.AgreementApproversID;
            }
            return Convert.ToInt32(aggrementApproversID);
        }

        public void InsertStatus(int approversStatus, int agreementTypeID)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@SubmitApprovers", approversStatus));
            Parameters.Add(new SqlParameter("@AgreementTypeID", agreementTypeID));
            Parameters.Add(new SqlParameter("@Action", "SS"));
            ExecCommand(DBCommands.Approvers);
        }
        public ApproversEntity Read(int agreementID)
        {

            Parameters = new List<SqlParameter>();

            Parameters.Add(new SqlParameter("@AgreementTypeID", agreementID));
            ApproversEntity entity = null;
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "R"));
                reader = ExecDataReader(DBCommands.Approvers);
                if (reader.Read())
                {
                    entity = new ApproversEntity();
                    entity.AgreementApproversID = reader["AgreementApproversID"].ToInt32();
                    entity.AgreementReviewer = reader["AgreementReviewer"].ToInt32();
                    entity.BusinessReviewer = reader["BusinessReviewer"].ToInt32();
                    entity.LawyerApprover = reader["LawyerApprover"].ToInt32();
                    entity.OtherApprover = reader["OtherApprover"].ToInt32();
                    
                }
            }
            finally
            {
                if (reader != null)
                {
                    reader.Close();
                    reader.Dispose();
                }
            }

            return entity;

        }
    }
}
   