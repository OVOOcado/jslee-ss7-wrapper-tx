/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.RedirectionInformationInap;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper;


/**
 * TxRedirectionInformationWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRedirectionInformationWrapper implements RedirectionInformationWrapper {

    /** The redirection information. */
    private final RedirectionInformationInap redirectionInformation;

    /**
     * Instantiates a new tx redirection information wrapper.
     *
     * @param redirectionInformation the redirection information
     */
    public TxRedirectionInformationWrapper(final RedirectionInformationInap redirectionInformation) {
        this.redirectionInformation = redirectionInformation;
    }

    /**
     * Gets the tx redirection information.
     *
     * @return the tx redirection information
     */
    public RedirectionInformationInap getTxRedirectionInformation() {
        return redirectionInformation;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper#hasOriginalReason()
     */
    @Override
    public boolean hasOriginalReason() throws Ss7WrapperException {
        try {
            return redirectionInformation.getRedirectionInformation() != null;
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper#hasRedirecting()
     */
    @Override
    public boolean hasRedirecting() throws Ss7WrapperException {
        try {
            return redirectionInformation.getRedirectionInformation() != null;
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper#hasRedirectingReason()
     */
    @Override
    public boolean hasRedirectingReason() throws Ss7WrapperException {
        try {
            return redirectionInformation.getRedirectionInformation() != null;
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper#getOriginalReason()
     */
    @Override
    public OriginalReason getOriginalReason() throws Ss7WrapperException {
        try {
            return OriginalReason.valueOf(redirectionInformation.getRedirectionInformation().getOriginalRedirectionReason());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper#getRedirecting()
     */
    @Override
    public Redirecting getRedirecting() throws Ss7WrapperException {
        try {
            return Redirecting.valueOf(redirectionInformation.getRedirectionInformation().getRedirectingIndicator());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper#getRedirectingReason()
     */
    @Override
    public RedirectingReason getRedirectingReason() throws Ss7WrapperException {
        try {
            return RedirectingReason.valueOf(redirectionInformation.getRedirectionInformation().getRedirectionReason());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TxRedirectionInformationWrapper [redirectionInformation=" + redirectionInformation + "]";
	}
    
}
