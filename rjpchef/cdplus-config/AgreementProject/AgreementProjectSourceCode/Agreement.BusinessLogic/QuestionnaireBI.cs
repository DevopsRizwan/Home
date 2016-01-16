/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Agreement.BusinessEntity;
using Agreement.DataAccess;

namespace Agreement.BusinessLogic
{
    public class QuestionnaireBI
    {
        public List<QuestionnaireEntity> ReadList()
        {
            QuestionnaireDao questionnaireDao = new QuestionnaireDao();
            return questionnaireDao.ReadList();
        }
    }
}
