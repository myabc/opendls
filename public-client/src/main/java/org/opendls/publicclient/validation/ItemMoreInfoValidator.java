package org.opendls.publicclient.validation;

import org.opendls.publicclient.command.MoreInfoCommand;

import org.apache.oro.text.perl.Perl5Util;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ItemMoreInfoValidator implements Validator
{

 private static final String EMAIL_REGEXP = "/^[a-z0-9]+([_\\.-][a-z0-9]+)*"
  + "@([a-z0-9]+([\\.-][a-z0-9]+)*)+\\.[a-z]{2,}$/i";

 public boolean supports(Class clazz)
 {
  return clazz.equals(MoreInfoCommand.class);
 }

 public void validate(Object command, Errors errors)
 {
  MoreInfoCommand moreInfo = (MoreInfoCommand) command;

  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemId",
    "required.itemId",
    "The item identifier is missing.");
  validateEmail(moreInfo.getFromEmail(), errors);
 }

 private void validateEmail(String email, Errors errors)
 {
  ValidationUtils.rejectIfEmpty(errors,"fromEmail","required.email",
    "Sorry, but we do need an email address to answer your request.");

  Perl5Util perl5Util = new Perl5Util();
  if(!perl5Util.match(EMAIL_REGEXP, email))
  {
   errors.reject("invalid.email",
     "Sorry, but we do need an email address to answer your request.");
  }

 }

}
