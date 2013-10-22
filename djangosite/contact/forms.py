from django import forms
from contact.models import Contact

class ContactForm(forms.ModelForm):

    def __init__(self, *args, **kwargs):
        super(ContactForm, self).__init__(*args, **kwargs)
        self.fields['subject'].required = True
        self.fields['subject'].initial = 'Hi there!'

        self.fields['message'].required = True
        self.fields['message'].initial = 'Your message here ...'
        self.fields['message'].widget = forms.Textarea(
            attrs={'rows': '5', 'cols': '80'})

        self.fields['sender'].label = 'Your email'
        self.fields['sender'].help_text = 'Enter a valid email address, please'

        self.fields['gender'].initial = 2

        self.fields['cc'].label = 'CC'
        self.fields['cc'].initial = True
        self.fields['cc'].widget = forms.HiddenInput()

    class Meta:
        model = Contact
        fields = ('subject', 'sender', 'gender', 'message', 'cc',)

class PureContactForm(forms.Form):

    def __init__(self, *args, **kwargs):
        super(PureContactForm, self).__init__(*args, **kwargs)
        self.fields['subject'] = forms.CharField(max_length=100)
        self.fields['subject'].required = True
        self.fields['subject'].initial = 'Hi there!'

        self.fields['message'] = forms.CharField()
        self.fields['message'].required = True
        self.fields['message'].initial = 'Your message here ...'
        self.fields['message'].widget = forms.Textarea(
            attrs={'rows': '5', 'cols': '80'})

        self.fields['cc'] = forms.BooleanField()
        self.fields['cc'].label = 'CC'
        self.fields['cc'].initial = True


        self.fields['gender'] = forms.ChoiceField(choices=GENDER_CHOICES)
        self.fields['gender'].initial = 3
