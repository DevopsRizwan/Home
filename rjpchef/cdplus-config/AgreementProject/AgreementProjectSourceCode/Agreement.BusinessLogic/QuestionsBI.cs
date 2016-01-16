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
using Agreement.DataAccess;
using Agreement.BusinessEntity;
namespace Agreement.BusinessLogic
{
    public class QuestionsBI
    {
        public void InsertQuestion(QuestionsEntity entity)
        {
            QuestionsDao questionsDao = new QuestionsDao();
            questionsDao.InsertQuestion(entity);

        }
        public List<QuestionsEntity> ReadList()
        {
            QuestionsDao questionsDao = new QuestionsDao();
            return questionsDao.ReadList();

        }

        public QuestionsEntity Read(int Sno)
        {
            QuestionsDao questionsDao = new QuestionsDao();
            return questionsDao.Read(Sno);
        }
        public void Delete(int Sno)
        {
            QuestionsDao questionsDao = new QuestionsDao();
            questionsDao.Delete(Sno);
        }
        
    }
}
