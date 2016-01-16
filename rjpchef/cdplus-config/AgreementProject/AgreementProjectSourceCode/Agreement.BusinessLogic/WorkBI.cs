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
    public class WorkBI
    {
        public int Insert(WorkEntity entity)
        {
            WorkDao workDao = new WorkDao();
            return workDao.Insert(entity);

        }
        public WorkEntity Read(int agreementID)
        {
            WorkDao workDao = new WorkDao();
            return workDao.Read(agreementID);

        }
        public void InsertStatus(int workStatus, int agreementTypeID)
        {
            WorkDao workDao = new WorkDao();
            workDao.InsertStatus(workStatus, agreementTypeID);

        }
    }
}
