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
    public class QuestionnaireDao : SQLDataAccess
    {
        public List<QuestionnaireEntity> ReadList()
        {
            Parameters = new List<SqlParameter>();
            List<QuestionnaireEntity> list = new List<QuestionnaireEntity>();
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "RL"));
                reader = ExecDataReader(DBCommands.Questionnaire);
                while (reader.Read())
                {
                    QuestionnaireEntity entity = new QuestionnaireEntity();
                    entity.QuestionID = reader["QuestionID"].ToInt32();
                    entity.Sno = reader["Sno"].ToInt32();
                    entity.Question = reader["Question"].ToStr();
                    entity.AnswerType = reader["AnswerType"].ToStr();
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
