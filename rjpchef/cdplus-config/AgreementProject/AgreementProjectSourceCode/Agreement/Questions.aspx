<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="Questions.aspx.cs" Inherits="Agreement.Questions" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <strong>Questions</strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
        <tr>
            <td width="25%">
                Question
            </td>
            <td width="45%">
                <asp:TextBox ID="txtQuestion" runat="server" Width="100%"></asp:TextBox>
            </td>
            <td width="30%">
            </td>
        </tr>
        <tr>
            <td>
                Answer Type
            </td>
            <td>
                <asp:RadioButtonList ID="rdoAnswerType" runat="server">
                    <asp:ListItem Text="YesNo" Value="Y"></asp:ListItem>
                    <asp:ListItem Text="Descriptive" Value="D"></asp:ListItem>
                </asp:RadioButtonList>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td>
                Sr. No
            </td>
            <td>
                <asp:TextBox ID="txtSrNo" runat="server"></asp:TextBox>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <asp:Button ID="btnSave" runat="server" Text="Save" onclick="btnSave_Click" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<asp:Button ID="btnCancel" runat="server"
                    Text="Cancel" />
            </td>
        </tr>
        <tr>
        <td colspan="3">
            <asp:GridView ID="gvQuestions" runat="server" AutoGenerateColumns="false" 
                Width="100%" onrowcommand="gvQuestions_RowCommand"  AllowSorting="true" 
                onsorting="gvQuestions_Sorting">
            <Columns>
            <asp:BoundField DataField="Sno" HeaderText="S. No" SortExpression="Sno" />
            <asp:BoundField DataField="Question" HeaderText="Question" />
            <asp:BoundField DataField="AnswerType" HeaderText="Answer Type" />
            <asp:TemplateField HeaderText="Action" >
                            <ItemTemplate>
                                <asp:LinkButton ID="lnkEdit" Text="Edit" runat="server" CommandArgument='<%#Eval("QuestionID") %>'
                                    CommandName="E" ForeColor="Blue"></asp:LinkButton>
                                &nbsp;
                                <asp:LinkButton ID="lnkDelete" Text="Delete" runat="server" CommandArgument='<%#Eval("QuestionID") %>'
                                    CommandName="D" ForeColor="Blue"></asp:LinkButton>
                                 
                            </ItemTemplate>
                        </asp:TemplateField>
            </Columns>
            </asp:GridView>
        </td>
        </tr>
    </table>
</asp:Content>
