<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="AgreementType.aspx.cs" Inherits="Agreement.AgreementType" %>

<%@ Register Src="Navigator.ascx" TagName="Navigator" TagPrefix="uc1" %>
<%@ Register Src="UserControls/AgreementTypeControl.ascx" TagName="AgreementTypeControl"
    TagPrefix="uc2" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <strong>Agreement Type</strong>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
      <%--  <tr>
            <td>
                <uc1:Navigator ID="Navigator1" runat="server" />
            </td>
        </tr>--%>
        <tr>
            <td>
             <uc2:AgreementTypeControl ID="AgreementTypeControl1" runat="server" />
            </td>
        </tr>
    </table>
   
</asp:Content>
