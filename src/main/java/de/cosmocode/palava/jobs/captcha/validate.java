/**
 * palava - a java-php-bridge
 * Copyright (C) 2007-2010  CosmoCode GmbH
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package de.cosmocode.palava.jobs.captcha;

import com.google.inject.Inject;

import de.cosmocode.palava.bridge.Content;
import de.cosmocode.palava.bridge.call.Call;
import de.cosmocode.palava.bridge.command.Command;
import de.cosmocode.palava.bridge.command.CommandException;
import de.cosmocode.palava.bridge.content.TextContent;
import de.cosmocode.palava.captcha.Validate;
import de.cosmocode.palava.services.captcha.Captcha;

/**
 * Validates the current captcha against the user input.
 *
 * @deprecated use {@link Validate} instead
 *
 * @author Willi Schoenborn
 */
@Deprecated
public class validate implements Command {

    @Inject
    private Captcha captcha;
    
    @Override
    public Content execute(Call call) throws CommandException {
        final String userInput = call.getArguments().getString("code");
        final boolean result = captcha.validate(call.getHttpRequest().getHttpSession().getSessionId(), userInput);
        
        return new TextContent(Boolean.toString(result));
    }

}
