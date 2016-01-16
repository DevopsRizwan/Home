/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Configuration;
using System.Data.SqlClient;
using Agreement.BusinessEntity;
using Agreement.WebHelper;
namespace Agreement.DataAccess
{
    public class QuestionsDao : SQLDataAccess
    {
        public void InsertQuestion(QuestionsEntity entity)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@QuestionID", entity.QuestionID));
            Parameters.Add(new SqlParameter("@Sno", entity.Sno));
            Parameters.Add(new SqlParameter("@Question", entity.Question));
            Parameters.Add(new SqlParameter("@AnswerType", entity.AnswerType));
            if (entity.QuestionID == 0)
            {
                Parameters.Add(new SqlParameter("@Action", "C"));
                ExecCommand(DBCommands.Question);
            }
            else
            {
                Parameters.Add(new SqlParameter("@Action", "U"));
                ExecCommand(DBCommands.Question);
            }
        }

        public List<QuestionsEntity> ReadList()
        {
            List<QuestionsEntity> list = new List<QuestionsEntity>();
            Parameters = new List<SqlParameter>();
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "RL"));
                reader = ExecDataReader(DBCommands.Question);
                while (reader.Read())
                {
                    QuestionsEntity entity = new QuestionsEntity();
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

        public QuestionsEntity Read(int questionID)
        {
            Parameters = new List<SqlParameter>();

            Parameters.Add(new SqlParameter("@QuestionID", questionID));
            QuestionsEntity entity = null;
            SqlDataReader reader = null;
            try
            {
                Parameters.Add(new SqlParameter("@Action", "R"));
                reader = ExecDataReader(DBCommands.Question);
                if (reader.Read())
                {
                    entity = new QuestionsEntity();
                    entity.Sno = reader["Sno"].ToInt32();
                    entity.Question = reader["Question"].ToStr();
                    entity.AnswerType = reader["AnswerType"].ToStr();
                
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

        public void Delete(int questionID)
        {
            Parameters = new List<SqlParameter>();
            Parameters.Add(new SqlParameter("@QuestionID", questionID));
            Parameters.Add(new SqlParameter("@Action", "D"));
            ExecCommand(DBCommands.Question);
        }
    }
}
