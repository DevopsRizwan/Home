<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="Approval.aspx.cs" Inherits="Agreement.Approval" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <Strong>Approval</Strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
        <tr style="height: 30px" >
            <td>
                Agreement Title:-
            
            </td>
            <td>
                <asp:Label ID="lblAgreementTitle" runat="server" Text="AgreementTitle"></asp:Label>
            </td>
        </tr>
        <tr style="height: 30px" >
            <td>
                Agreement No.:-
            </td>
            <td>
                <asp:Label ID="lblAgreementNo" runat="server" Text="AgreementNo"></asp:Label>
            </td>
        </tr>
        <tr>
            <td>
                Comments:-
            </td>
            <td>
                <asp:TextBox ID="txtComment" runat="server" TextMode="multiline" Width="250px"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td>
               Corrective Actions:-
            </td>
            <td>
                <asp:TextBox ID="txtAction"  runat="server" TextMode="multiline" 
                    style="margin-right: 18px" Width="247px"></asp:TextBox>
                </td>
                <td>
                <asp:RequiredFieldValidator ID="valReqActions" runat="server" 
                    ErrorMessage="Please list down the Actions before reject the Page" 
                        ControlToValidate="txtAction" Display="Dynamic" ForeColor="Red" 
                        SetFocusOnError="True" ValidationGroup="Reject"></asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
        <td>
        </td>
        <td>
            <asp:Button ID="btnApprove" runat="server" Text="Approve" 
                onclick="btnApprove_Click" />&nbsp
            <asp:Button ID="btnReject" runat="server" Text="Reject" 
                onclick="btnReject_Click" ValidationGroup="Reject" />&nbsp
            <asp:Button ID="btnCancel" runat="server" Text="Cancel" 
                onclick="btnCancel_Click" style="height: 26px" />
        </td>
        </tr>
    </table>
</asp:Content>
