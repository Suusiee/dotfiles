# ~/.bashrc

export PATH=$HOME/usr/bin:$PATH

export JAVA_HOME=/Library/Java/Home
export JAVA_OPTS="-server -Xms128m -Xmx1024m -XX:MaxPermSize=256m"
export CLASSPATH=.

export ANT_HOME=$HOME/usr/ant

export BLOCKSIZE=K
export PAGER='less'

alias ls='ls -AFGl'
alias dir='\ls -AFG'
alias cpl='clear; pwd; ls'

alias cp='cp -i'
alias mv='mv -i'
alias rm='rm -i'

alias h='history'
alias ..='cd ..'

alias gvim='gvim -reverse'

PS1='\h:\w$(__git_ps1 " (%s)")\$ '

HISTIGNORE="bg:cd:clear:exit:fg:jobs:ls:ps:pwd:w"
HISTCONTROL=ignoredups
HISTFILESIZE=10000
HISTSIZE=500

# append to the history file, don't overwrite it
shopt -s histappend

umask 0077

mesg n

# Git tab completion
GTC='/usr/local/git/contrib/completion/git-completion.bash'
[ -r $GTC ] && . $GTC 

# Git aliases
alias add='     git add                            '
alias amend='   git commit                --amend  '
alias branch='  git branch                         '
alias commit='  git commit                         '
alias cout='    git checkout                       '
alias dif='     git diff                           '
alias difftool='git difftool                       '
alias ignored=' git status                --ignored'
alias list='    git stash       list      --summary'
alias log='     git log                            '
alias master='  git checkout    master             '
alias pop='     git stash       pop                '
alias pull='    git pull                  --rebase '
alias push='    git push                           '
alias stash='   git stash                          '
alias status='  git status                         '
alias summary=' git log                   --summary'
