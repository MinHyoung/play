from django.http import HttpResponse,   HttpResponseRedirect
from django.shortcuts import render, get_object_or_404
from contact.forms import ContactForm, PureContactForm

def contact(request, template_name='contact/contact.html'):
    # sticks in a POST or renders an empty form
    form = ContactForm(request.POST or None)
    if form.is_valid():
        subject = form.cleaned_data['subject']
        cc = form.cleaned_data['cc']
        print subject
        print cc
        # custom business logic
        form.save()
        return HttpResponseRedirect('/contact/thanks/')
    
    return render(request, template_name, {'form' : form})

def pure_contact(request, template_name='contact/pure_contact.html'):
    GENDER_CHOICES = (
        (1, 'Male'),
        (2, 'Female'),
        (3, 'Don\'t know')
    )
    # sticks in a POST or renders an empty form
    form = PureContactForm(request.POST or None)
    if form.is_valid():
        subject = form.cleaned_data['subject']
        cc = form.cleaned_data['cc']
        message = form.cleaned_data['message']
        gender = form.cleaned_data['gender']
        print "pure:::::"
        print subject
        print cc
        print message
        print gender
        return HttpResponseRedirect('/contact/thanks/')
    
    return render(request, template_name, {'form' : form})


def thanks(request):
    return HttpResponse("Thanks you.")