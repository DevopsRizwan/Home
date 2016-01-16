namespace Agreement.DataAccess
{
    /*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
    using System.Data;
    using System.Data.SqlClient;
    using System.Collections.Generic;
    using System.Configuration;
    public class SQLDataAccess : IDisposable
    {
       
        #region Private members
        //Private Members
        private int _commandTimeout;
        private string _connectionString;
        private SqlTransaction _sqlTransaction;
        private SqlConnection _sqlCon;


        #endregion

        #region Private methods
        //Private methods
        private void OpenConnection()
        {
            if (_sqlCon == null)
                _sqlCon = new SqlConnection(_connectionString);

            if (_sqlCon.State == ConnectionState.Closed)
                _sqlCon.Open();
        }
        private void CloseConnection()
        {
            if (_sqlTransaction == null)
                _sqlCon.Close();
        }
        #endregion

        #region Public Members
        //Public Members
        public SqlParameterCollection OutputParameters;
        public List<SqlParameter> Parameters = null;

        /// <summary>
        /// Begin Sql Transaction
        /// </summary>
        public void BeginTrans()
        {
            OpenConnection();
            _sqlTransaction = _sqlCon.BeginTransaction();
        }

        /// <summary>
        /// Commit Transaction
        /// </summary>
        public void Commit()
        {
            _sqlTransaction.Commit();
            _sqlTransaction = null;
            CloseConnection();
        }

        /// <summary>
        /// Rollback Transaction
        /// </summary>
        public void Rollback()
        {
            _sqlTransaction.Rollback();
        }

        /// <summary>
        /// Get or Set Command Timeout
        /// </summary>
        public int CommandTimeout
        {
            get { return _commandTimeout; }
            set { _commandTimeout = value; }
        }

        /// <summary>
        /// Constructor - Initialize Connection String
        /// </summary>
        public SQLDataAccess()
        {
            _connectionString = ConfigurationManager.ConnectionStrings["DbConn"].ConnectionString;
            _commandTimeout = 1000 * 60 * 60 * 20;
        }

        /// <summary>
        /// Fill command result set into dataSet variable
        /// </summary>
        /// <param name="dataSet">DataSet object</param>
        /// <param name="commandName">Stored Procedure Name</param>
        /// <param name="paramters">SQL parameter colelction</param>
        public void FillData(DataSet dataSet, string commandName, CommandType commandType = CommandType.StoredProcedure)
        {
            OpenConnection();

            using (SqlCommand cm = _sqlCon.CreateCommand())
            {
                if (cm.CommandTimeout != 0)
                    cm.CommandTimeout = CommandTimeout;

                cm.CommandText = commandName;
                cm.CommandType = commandType;

                if (Parameters != null)
                    cm.Parameters.AddRange(Parameters.ToArray());

                SqlDataAdapter adp = new SqlDataAdapter(cm);

                try
                {
                    adp.Fill(dataSet);
                    OutputParameters = cm.Parameters;
                }
                catch (SqlException ex)
                {
                    //ExceptionLog.Write(ex, cm);
                    throw ex;
                }
                finally
                {
                    CloseConnection();
                }
            }
        }
        /// <summary>
        /// Execute DataReader
        /// </summary>
        /// <param name="commandName">Stored Procedure Name</param>
        /// <param name="paramters">SQL parameter colelction</param>
        /// <returns></returns>
        public SqlDataReader ExecDataReader(string commandName, CommandType commandType = CommandType.StoredProcedure)
        {
            OpenConnection();
            using (SqlCommand sqlCmd = new SqlCommand(commandName, _sqlCon))
            {
                try
                {
                    if (_sqlTransaction != null)
                        sqlCmd.Transaction = _sqlTransaction;

                    if (sqlCmd.CommandTimeout != 0)
                        sqlCmd.CommandTimeout = CommandTimeout;

                    sqlCmd.CommandType = commandType;

                    if (Parameters != null)
                    {
                        sqlCmd.Parameters.AddRange(Parameters.ToArray());
                    }
                    return sqlCmd.ExecuteReader();
                }
                catch (SqlException ex)
                {
                    //ExceptionLog.Write(ex, sqlCmd);
                    throw ex;
                }
            }
        }

        /// <summary>
        /// Execute Scalar
        /// </summary>
        /// <param name="commandName">Stored Procedure Name</param>
        /// <param name="paramters">SQL parameter colelction</param>
        /// <returns></returns>
        public object ExecuteScalar(string commandName, CommandType commandType = CommandType.StoredProcedure)
        {
            OpenConnection();
            using (SqlCommand sqlCmd = new SqlCommand(commandName, _sqlCon))
            {
                try
                {
                    if (_sqlTransaction != null)
                        sqlCmd.Transaction = _sqlTransaction;

                    if (sqlCmd.CommandTimeout != 0)
                        sqlCmd.CommandTimeout = CommandTimeout;

                    sqlCmd.CommandType = commandType;

                    if (Parameters != null)
                    {
                        sqlCmd.Parameters.AddRange(Parameters.ToArray());
                    }

                    object obj = sqlCmd.ExecuteScalar();
                    OutputParameters = sqlCmd.Parameters;
                    return obj;

                }
                catch (SqlException ex)
                {
                    //ExceptionLog.Write(ex, sqlCmd);
                    throw ex;
                }
                finally
                {
                    CloseConnection();
                }
            }
        }

        /// <summary>
        /// Execute SQL Stored Procedure
        /// </summary>
        /// <param name="commandName">Stored Procedure Name</param>
        /// <param name="paramters">SQL parameter colelction</param>
        /// <returns></returns>
        public int ExecCommand(string commandName, CommandType commandType = CommandType.StoredProcedure)
        {
            int effectedRows = 0;
            OpenConnection();
            using (SqlCommand sqlCmd = new SqlCommand(commandName, _sqlCon))
            {
                try
                {
                    sqlCmd.CommandType = commandType;

                    if (_sqlTransaction != null)
                        sqlCmd.Transaction = _sqlTransaction;

                    if (sqlCmd.CommandTimeout != 0)
                        sqlCmd.CommandTimeout = CommandTimeout;

                    if (Parameters != null)
                        sqlCmd.Parameters.AddRange(Parameters.ToArray());

                    effectedRows = sqlCmd.ExecuteNonQuery();

                    //output values
                    OutputParameters = sqlCmd.Parameters;
                }
                catch (SqlException ex)
                {
                    //ExceptionLog.Write(ex, sqlCmd);
                    throw ex;
                }
                finally
                {
                    CloseConnection();
                }
                return effectedRows;
            }
        }

        /// <summary>
        /// Free the allocated resources
        /// </summary>
        public void Dispose()
        {
            if (_sqlTransaction != null)
            {
                _sqlTransaction.Dispose();
                _sqlTransaction = null;
            }

            if (_sqlCon != null)
            {
                if (_sqlCon.State != ConnectionState.Closed)
                    _sqlCon.Close();

                _sqlCon.Dispose();
                _sqlCon = null;
            }

            GC.SuppressFinalize(this);
        }

        #endregion
    }
}