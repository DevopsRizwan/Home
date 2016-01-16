<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="Questionnaire.aspx.cs" Inherits="Agreement.Questionnaire" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <strong>Questionnaire</strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
        <tr>
            <td>
                <asp:GridView ID="gvQuestionnaire" runat="server" Width="100%" 
                    AutoGenerateColumns="false" onrowdatabound="gvQuestionnaire_RowDataBound" 
                    onselectedindexchanged="gvQuestionnaire_SelectedIndexChanged">
                <Columns>
                <asp:BoundField DataField="Sno" HeaderText="S. No" />
                <asp:BoundField DataField="Question" HeaderText="Question" />
                <asp:TemplateField HeaderText="Answer" >
                            <ItemTemplate>
                                <asp:Label ID="lblAnswer" runat="server" Visible="false" CommandArgument='<%#Eval("AnswerType") %>'
                                    CommandName="A" />
                                <asp:TextBox ID="txtAnswer" runat="server"  ></asp:TextBox>
                                <asp:RadioButtonList ID="rdoAnswer" runat="server" RepeatDirection="Horizontal">
                                <asp:ListItem Text="Yes" Value="Y" />
                                <asp:ListItem Text="No" Value="N" />
                                </asp:RadioButtonList>
                            </ItemTemplate>
                        </asp:TemplateField>
                </Columns>
                </asp:GridView>
            </td>
        </tr>
        <tr>
            <td align="center">
                <br />
                <asp:Button ID="Button1" runat="server" Text="Previous" />
                &nbsp;&nbsp
                <%--<asp:Button ID="btnSaveasDraft" runat="server" Text="Save as Draft" 
                    onclick="btnSaveasDraft_Click" />--%>
                &nbsp;&nbsp<asp:Button ID="btnSave" runat="server" Text="Save" />
                <asp:Button ID="Button2" runat="server" Text="Next" />
                &nbsp;&nbsp
                <asp:Button ID="btnCancel" runat="server" Text="Cancel" />
            </td>
        </tr>
    </table>
</asp:Content>
