/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.isup.RedirectionInformationInap;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.RedirectionInformationWrapper;

/**
 * TxRedirectionInformationWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRedirectionInformationWrapper implements RedirectionInformationWrapper {

    private final RedirectionInformationInap redirectionInformation;

    public TxRedirectionInformationWrapper(final RedirectionInformationInap redirectionInformation) {
        this.redirectionInformation = redirectionInformation;
    }

    public RedirectionInformationInap getTxRedirectionInformation() {
        return redirectionInformation;
    }

    @Override
    public boolean hasOriginalReason() throws Ss7WrapperException {
        try {
            return redirectionInformation.getRedirectionInformation() != null;
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public boolean hasRedirecting() throws Ss7WrapperException {
        try {
            return redirectionInformation.getRedirectionInformation() != null;
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public boolean hasRedirectingReason() throws Ss7WrapperException {
        try {
            return redirectionInformation.getRedirectionInformation() != null;
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public OriginalReason getOriginalReason() throws Ss7WrapperException {
        try {
            return OriginalReason.valueOf(redirectionInformation.getRedirectionInformation().getOriginalRedirectionReason());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public Redirecting getRedirecting() throws Ss7WrapperException {
        try {
            return Redirecting.valueOf(redirectionInformation.getRedirectionInformation().getRedirectingIndicator());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public RedirectingReason getRedirectingReason() throws Ss7WrapperException {
        try {
            return RedirectingReason.valueOf(redirectionInformation.getRedirectionInformation().getRedirectionReason());
        } catch (INAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

	@Override
	public String toString() {
		return "TxRedirectionInformationWrapper [redirectionInformation=" + redirectionInformation + "]";
	}
    
}
