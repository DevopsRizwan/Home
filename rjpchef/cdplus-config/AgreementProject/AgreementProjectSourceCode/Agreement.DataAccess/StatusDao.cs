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
    public class StatusDao : SQLDataAccess
    {
        public List<StatusEntity> ReadList(int agreementTypeID)
        {
            Parameters = new List<SqlParameter>();
            List<StatusEntity> list = new List<StatusEntity>();
            SqlDataReader reader = null;
            try
            {
                // Parameters.Add(new SqlParameter("@Action", "RL"));
                Parameters.Add(new SqlParameter("@AgreementTypeID", agreementTypeID));
                reader = ExecDataReader(DBCommands.Status);
                while (reader.Read())
                {
                    StatusEntity entity = new StatusEntity();
                    entity.Sno = reader["Sno"].ToInt32();
                    entity.Item = reader["Item"].ToStr();
                    entity.User = reader["User"].ToStr();
                    entity.Status = reader["Status"].ToStr();
                    entity.Comments = reader["Comments"].ToStr();
                    entity.Actions = reader["Actions"].ToStr();
                    entity.ActionDate = reader["ActionDate"].ToDateTime();

                    list.Add(entity);
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
            return list;
        }
    }
}
