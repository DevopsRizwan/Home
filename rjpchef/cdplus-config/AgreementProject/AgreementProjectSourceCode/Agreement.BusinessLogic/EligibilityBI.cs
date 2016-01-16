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
    public class EligibilityBI
    {
        public int Insert(EligibilityEntity entity)
        {

            //logic goes here

            EligibilityDao eligibilityDao = new EligibilityDao();
            return eligibilityDao.Insert(entity);
        }
        public void InsertStatus(int eligibilityStatus, int agreementTypeID)
        {

            //logic goes here

            EligibilityDao eligibilityDao = new EligibilityDao();
            eligibilityDao.InsertStatus(eligibilityStatus, agreementTypeID);
        }
        
        public void Delete(int ID)
        {
            EligibilityDao eligibilityDao = new EligibilityDao();
            eligibilityDao.Delete(ID);
        }

        //public void DeleteAgreement(int ID)
        //{
        //    EligibilityDao eligibilityDao = new EligibilityDao();
        //    eligibilityDao.Delete(ID);
        //}

        public void DeleteMyAgreement(int ID)
        {
            EligibilityDao eligibilityDao = new EligibilityDao();
            eligibilityDao.DeleteMyAgreement(ID);
        }


        public EligibilityEntity Read(int id)
        {
            EligibilityDao eligibilityDao = new EligibilityDao();
            return eligibilityDao.Read(id);
        }
        public List<EligibilityEntity> ReadList(int id)
        {
            EligibilityDao eligibilityDao = new EligibilityDao();
            return eligibilityDao.ReadList(id);
        }
    }
}
