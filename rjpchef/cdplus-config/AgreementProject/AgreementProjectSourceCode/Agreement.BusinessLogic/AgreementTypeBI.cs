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
    public class AgreementTypeBI
    {
        public int Insert(AgreementTypeEntity entity)
        {

            //logic goes here
            AgreementDao AgreementDao = new AgreementDao();
            return AgreementDao.Insert(entity);

        }
        public List<AgreementTypeEntity> ReadSearchItem(AgreementTypeEntity entity)
        {

            //logic goes here
            AgreementDao AgreementDao = new AgreementDao();
            return AgreementDao.ReadSearchItem(entity);

        }
         public AgreementTypeEntity Read(int id)
        {
            AgreementDao agreementDao = new AgreementDao();
            return agreementDao.Read(id);
        }

         public void InsertStatus(int agreementTypeStatus, int agreementTypeID)
        {
             AgreementDao agreementDao = new AgreementDao();
             agreementDao.InsertStatus(agreementTypeStatus, agreementTypeID);
        }
         public List<AgreementTypeEntity> ReadList()
         {
             AgreementDao agreementDao = new AgreementDao();
             return agreementDao.ReadList();
         }

         public AgreementTypeEntity ReadTitle(int ID)
         {
             AgreementDao agreementDao = new AgreementDao();
            return agreementDao.ReadTitle(ID);
         }

         //public AgreementTypeEntity DisplayData(int id)
         //{
         //    AgreementDao agreementDao = new AgreementDao();
         //    return agreementDao.Read(id);
         //}
    }
}
